import json
def from_json(dic):
	java_code = ""
	for dept in dic:
		java_code += 'all.put("{}", new HashMap<Integer, HashMap<String, ArrayList<Course>>>());\n'.format(dept)
		for year in dic[dept]:
			java_code += 'all.get("{}").put({}, new HashMap<String, ArrayList<Course>>());\n'.format(dept, year) 
			for sem in dic[dept][year]:				# course_num = int(input("How many courses?: "))
				java_code += 'all.get("{}").get({}).put("{}", new ArrayList<Course>());\n'.format(dept, year, sem)
				print("Dept: {}, Year: {}, Semester: {}".format(dept, year, sem))
				cl = "\n"
				i = 0
				for cour in dic[dept][year][sem]:		
					c = cour[0]
					d = cour[1]
					cr = cour[2]
					cl += 'new Course("{}", "{}", {}){}\n'.format(c, d, cr, ',' if i!=len(dic[dept][year][sem])-1 else '')
					i += 1
				java_code += '\nall.get("{}").get({}).get("{}").addAll(Arrays.asList({}));\n'.format(dept, year, sem,cl)
	f = open("hash.java", "a")
	f.write(java_code)
	f.close()
	print(java_code)

# java_code = ""
# dept_num = int(input("How many departments?: "))
# for dept in range(dept_num):
# 	dept_name = input("Enter department name: ")
# 	for year in range(1, 5):
# 		for sem in ["Odd", "Even"]:
# 			java_code += 'all.put("{}", new HashMap<Integer, HashMap<String, ArrayList<Course>>>());\nall.get("{}").put({}, new HashMap<String, ArrayList<Course>>());\nall.get("{}").get({}).put("{}", new ArrayList<Course>());'.format(dept_name, dept_name, year, dept_name, year, sem)
# 			course_num = int(input("How many courses?: "))
# 			print("Dept: {}, Year: {}, Semester: {}".format(dept_name, year, sem))
# 			cl = "\n"
# 			for i in range(course_num):
# 				c = input("Enter course code {}: ".format(i+1))
# 				d = input("Enter course desc {}: ".format(i+1))
# 				cr = input("Enter course credit {}: ".format(i+1))
# 				cl += 'new Course("{}", "{}", {}){}\n'.format(c, d, cr, ',' if i!=course_num-1 else '')
# 			java_code += '\nall.get("{}").get({}).get("{}").addAll(Arrays.asList({}));\n'.format(dept_name, year, sem,cl)

with open('c-info.json') as f:
	js = json.load(f)
	from_json(js)
