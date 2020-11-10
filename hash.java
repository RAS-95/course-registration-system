all.put("CSE", new HashMap<Integer, HashMap<String, ArrayList<Course>>>());
all.get("CSE").put(1, new HashMap<String, ArrayList<Course>>());
all.get("CSE").get(1).put("Odd", new ArrayList<Course>());

all.get("CSE").get(1).get("Odd").addAll(Arrays.asList(
new Course("CSE 1100", "Computer Fundamentals and Ethics ", 1.5),
new Course("CSE 1101", "Computer Programming", 3.0),
new Course("CSE 1102", "Sessional Based on CSE 1101 ", 1.5),
new Course("EEE 1151", "Basic Electrical Engineering", 3.0),
new Course("EEE 1152", "Sessional Based on EEE 1151 ", 0.75),
new Course("Math 1113", "Differential and Integral Calculus ", 3.0),
new Course("Hum 1113", "Functional English", 3.0),
new Course("Hum 1114", "English Language Lab", 1.5),
new Course("Chem 1113", "Inorganic and Physical Chemistry", 3.0),
new Course("Chem 1114", "Sessional Based on Chem 1113 ", 0.75)
));
all.get("CSE").get(1).put("Even", new ArrayList<Course>());

all.get("CSE").get(1).get("Even").addAll(Arrays.asList(
new Course("CSE 1200", "Analytical Programming", 0.75),
new Course("CSE 1201", "Data Structure", 3.0),
new Course("CSE 1202", "Sessional Based on CSE 1201 ", 1.5),
new Course("CSE 1203", "Object Oriented Programming ", 3.0),
new Course("CSE 1204", "Sessional Based on CSE 1203 ", 1.5),
new Course("Math 1213", "Co-ordinate Geometry and Ordinary Differential Equation", 3.0),
new Course("Hum 1213", "Economics, Government and Sociology ", 3.0),
new Course("Phy 1213", "Physics", 3.0),
new Course("Phy 1214", "Sessional Based on Phy 1213", 1.5)
));
all.get("CSE").put(2, new HashMap<String, ArrayList<Course>>());
all.get("CSE").get(2).put("Odd", new ArrayList<Course>());

all.get("CSE").get(2).get("Odd").addAll(Arrays.asList(
new Course("CSE 2100", "Software Development Project I", 0.75),
new Course("CSE 2101", "Discrete Mathematics", 3.0),
new Course("CSE 2102", "Sessional Based on CSE 2101 ", 1.5),
new Course("CSE 2103", "Numerical Methods", 3.0),
new Course("CSE 2104 ", "Sessional Based on CSE 2103 ", 1.5),
new Course("EEE 2151 ", "Analog Electronics", 3.0),
new Course("EEE 2152", "Sessional Based on EEE 2151 ", 1.5),
new Course("Math 2113", "Vector Analysis and Linear Algebra ", 3.0),
new Course("Hum 2113 ", "Industrial Management and Accountancy", 3.0)
));
all.get("CSE").get(2).put("Even", new ArrayList<Course>());

all.get("CSE").get(2).get("Even").addAll(Arrays.asList(
new Course("CSE 2201", "Computer Algorithms", 3.0),
new Course("CSE 2202", "Sessional Based on CSE 2201 ", 1.5),
new Course("CSE 2203", "Digital Techniques", 3.0),
new Course("CSE 2204", "Sessional Based on CSE 2203 ", 1.5),
new Course("CSE 2205", "Finite Automata Theory", 3.0),
new Course("CSE 2206", "Sessional Based on CSE 2205 ", 0.75),
new Course("EEE 2251 ", "Electrical Machines and Instrumentations ", 3.0),
new Course("EEE 2252 ", "Sessional Based on EEE 2251 ", 0.75),
new Course("Math 2213", "Complex Variable Differential Equations and Harmonic Analysis ", 3.0)
));
all.get("CSE").put(3, new HashMap<String, ArrayList<Course>>());
all.get("CSE").get(3).put("Odd", new ArrayList<Course>());

all.get("CSE").get(3).get("Odd").addAll(Arrays.asList(
new Course("CSE 3100", "Web Based Application Lab/Project", 0.75),
new Course("CSE 3101", "Database Systems", 3.0),
new Course("CSE 3102", "Sessional Based on CSE 3101 ", 1.5),
new Course("CSE 3103", "Data Communication", 3.0),
new Course("CSE 3104", "Sessional Based on CSE 3103 ", 0.75),
new Course("CSE 3105", "Software Engineering", 3.0),
new Course("CSE 3107", "Applied Statistics and Queuing Theory", 3.0),
new Course("CSE 3109", "Microprocessors and Assembly Language ", 3.0),
new Course("CSE 3110", "Sessional Based on CSE 3109 ", 1.5),
new Course("CSE 3112", "Technical Writing and Presentation ", 0.75)
));
all.get("CSE").get(3).put("Even", new ArrayList<Course>());

all.get("CSE").get(3).get("Even").addAll(Arrays.asList(
new Course("CSE 3200", "Software Development Project II ", 0.75),
new Course("CSE 3201", "Operating Systems", 3.0),
new Course("CSE 3202", "Sessional Based on CSE 3201 ", 0.75),
new Course("CSE 3203", "Computer Architecture and Design ", 3.0),
new Course("CSE 3205", "Computer Networks", 3.0),
new Course("CSE 3206", "Sessional Based on CSE 3205", 1.5),
new Course("CSE 3207", "Peripherals and Interfacings", 3.0),
new Course("CSE 3208", "Sessional Based on CSE 3207", 0.75),
new Course("CSE 3209", "Artificial Intelligence ", 3.0),
new Course("CSE 3210", "Sessional Based on CSE 3209 ", 0.75)
));
