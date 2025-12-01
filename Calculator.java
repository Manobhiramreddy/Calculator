public class Calculator {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (true) {
			System.out.print("First integer: ");
			String s1 = sc.next();
			if (s1.equalsIgnoreCase("exit") || s1.equalsIgnoreCase("quit")) break;
			int a;
			try { a = Integer.parseInt(s1); } catch (Exception e) { System.out.println("Invalid integer"); sc.nextLine(); continue; }

			System.out.print("Operator  ");
			String opS = sc.next();
			if (opS.length() == 0) { System.out.println("No operator"); sc.nextLine(); continue; }
			char op = opS.charAt(0);
			if ("+-*/%".indexOf(op) < 0) { System.out.println("Invalid operator"); sc.nextLine(); continue; }

			System.out.print("Second integer: ");
			String s2 = sc.next();
			int b;
			try { b = Integer.parseInt(s2); } catch (Exception e) { System.out.println("Invalid integer"); sc.nextLine(); continue; }

			if ((op == '/' || op == '%') && b == 0) { System.out.println("Cannot divide by zero"); continue; }

			int res;
			if (op == '+') res = a + b;
			else if (op == '-') res = a - b;
			else if (op == '*') res = a * b;
			else if (op == '/') res = a / b;
			else res = a % b;

			System.out.println(res);
			sc.nextLine();
		}
		System.out.println("Goodbye.");
		sc.close();
	}
}
