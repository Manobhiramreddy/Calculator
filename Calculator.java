public class Calculator {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (true) {
			String line = sc.nextLine();
			if (line == null) break;
			line = line.trim();
			if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) break;
			if (line.isEmpty()) continue;
			double a, b;
			String op;
			java.util.regex.Pattern p = java.util.regex.Pattern.compile(
				"^\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*([+\\-*/%])\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*$"
			);
			java.util.regex.Matcher m = p.matcher(line);
			if (!m.matches()) {
				System.out.println("Invalid format. Use: <number><operator><number> or with spaces, e.g. 5+3 or 5 + 3");
				continue;
			}
			try {
				a = Double.parseDouble(m.group(1));
				op = m.group(2);
				b = Double.parseDouble(m.group(3));
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Please enter valid numeric operands.");
				continue;
			}
			try {
				double res = compute(a, op, b);
				if (res == Math.rint(res)) {
					System.out.println((long) res);
				} else {
					System.out.println(res);
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Goodbye.");
		sc.close();
	}

	static double compute(double a, String op, double b) {
		switch (op) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				if (b == 0) throw new IllegalArgumentException("Error: Division by zero");
				return a / b;
			case "%":
				if (b == 0) throw new IllegalArgumentException("Error: Modulo by zero");
				return a % b;
			default:
				throw new IllegalArgumentException("Unsupported operator: " + op);
		}
	}
}
