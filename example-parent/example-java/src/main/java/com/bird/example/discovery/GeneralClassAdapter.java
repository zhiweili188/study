package com.bird.example.discovery;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;

public class GeneralClassAdapter extends ClassAdapter {
	public GeneralClassAdapter(ClassVisitor cv) {
		super(cv);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		// 当是sayName方法是做对应的修改
		if (name.equals("sayName")) {
			MethodVisitor newMv = new SayNameMethodAdapter(mv);
			return newMv;
		}
		if (name.equals("sleep")) {
			return new ModifyMethod(mv, access, name, desc);
		} else {
			return mv;
		}
	}

	// 定义一个自己的方法访问类
	class SayNameMethodAdapter extends MethodAdapter {
		public SayNameMethodAdapter(MethodVisitor mv) {
			super(mv);
		}

		// 在源方法前去修改方法内容,这部分的修改将加载源方法的字节码之前
		@Override
		public void visitCode() {
			// 记载隐含的this对象，这是每个JAVA方法都有的
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			// 从常量池中加载“Kuzury”字符到栈顶
			mv.visitLdcInsn("Kuzury");
			// 将栈顶的"Kuzury"赋值给name属性
			mv.visitFieldInsn(Opcodes.PUTFIELD, Type.getInternalName(HelloWorld.class), "name",
					Type.getDescriptor(String.class));
		}

	}

	@Override
	public void visitEnd() {
		FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC, "age", Type.getDescriptor(int.class), null, null);
		cv.visitField(Opcodes.ACC_PRIVATE + Opcodes.ACC_STATIC, "timer", "J", null, null);
	}

}
