import json
import mysql.connector
def insert(c, d, cr):
	mydb = mysql.connector.connect(
	  host="localhost",
	  user="root",
	  password="",
	  database="course_registration_system"
	)

	mycursor = mydb.cursor()

	sql = "INSERT INTO course_info (code, description, credit) VALUES (%s, %s, %s)"
	val = (c, d, float(cr))
	mycursor.execute(sql, val)

	mydb.commit()

	print(mycursor.rowcount, f'{c} inserted')

def from_json(dic):
	for dept in dic:
		for year in dic[dept]:
			for sem in dic[dept][year]:				# course_num = int(input("How many courses?: "))
				print("Dept: {}, Year: {}, Semester: {}".format(dept, year, sem))
				cl = "\n"
				i = 0
				for cour in dic[dept][year][sem]:		
					c = cour[0]
					d = cour[1]
					cr = cour[2]
					# cl += 'new Course("{}", "{}", {}){}\n'.format(c, d, cr, ',' if i!=len(dic[dept][year][sem])-1 else '')
					insert(c, d, cr)
					i += 1

with open('c-info.json') as f:
	js = json.load(f)
	from_json(js)