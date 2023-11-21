function solve(input) {
    class Student {
        constructor(username, email, credits) {
            this.username = username;
            this.email = email;
            this.credits = credits;
        }
    }

    class Course {
        constructor(name, capacity) {
            this.students = [];
            this.name = name;
            this.capacity = Number(capacity);
        }

        addStudent(student) {
            if (this.capacity > 0) {
                this.students.push(student);
                this.capacity--;
            }
        }

        sortStudents() {
            this.students.sort((a,b) => b.credits - a.credits);
        }

        addCapacity(integer) {
            this.capacity += Number(integer);
        }

        countStudents() {
            return this.students.length;
        }
    }

    function fillCourses(input) {
        let courses = new Map();

        for (let line of input) {
            if (line.includes(': ')) { // is a course
                let tokens = line.split(': ');
                let courseName = tokens[0];
                let capacity = Number(tokens[1]);

                if (!courses.has(courseName)) {
                    courses.set(courseName, new Course(courseName, capacity));
                } else {
                    courses.get(courseName).addCapacity(capacity);
                }

            } else { // is a student joining
                let firstTokens = line.split(' with email ');
                let userInfo = firstTokens[0].split('[');
                let courseInfo = firstTokens[1].split(' joins ');

                let username = userInfo[0];
                let credits = userInfo[1].replace(']','');
                let email = courseInfo[0];
                let course = courseInfo[1];

                let student = new Student(username, email, credits);

                if (courses.has(course)) {
                    courses.get(course).addStudent(student);
                }
            }
        }

        return courses;
    }

    let courses = fillCourses(input);

    function sortAndPrint(courses) {
        let sortedCourses = new Map([...courses.entries()].sort((a,b) => {
            let courseA = a[1].countStudents();
            let courseB = b[1].countStudents();
            return courseB - courseA;
        }));

        sortedCourses.forEach(course => {
            course.sortStudents();

            console.log(`${course.name}: ${course.capacity} places left`);

            course.students.forEach(student => {
                console.log(`--- ${student.credits}: ${student.username}, ${student.email}`);
            });
        })
    }

    sortAndPrint(courses);

}

solve(['JavaBasics: 2', 'user1[25] with email user1@user.com joins C#Basics', 'C#Advanced: 3', 'JSCore: 4',
    'user2[30] with email user2@user.com joins C#Basics', 'user13[50] with email user13@user.com joins JSCore',
    'user1[25] with email user1@user.com joins JSCore', 'user8[18] with email user8@user.com joins C#Advanced',
    'user6[85] with email user6@user.com joins JSCore', 'JSCore: 2',
    'user11[3] with email user11@user.com joins JavaBasics', 'user45[105] with email user45@user.com joins JSCore',
    'user007[20] with email user007@user.com joins JSCore', 'user700[29] with email user700@user.com joins JSCore',
    'user900[88] with email user900@user.com joins JSCore']);

solve(['JavaBasics: 15', 'user1[26] with email user1@user.com joins JavaBasics',
    'user2[36] with email user11@user.com joins JavaBasics', 'JavaBasics: 5', 'C#Advanced: 5',
    'user1[26] with email user1@user.com joins C#Advanced', 'user2[36] with email user11@user.com joins C#Advanced',
    'user3[6] with email user3@user.com joins C#Advanced', 'C#Advanced: 1', 'JSCore: 8',
    'user23[62] with email user23@user.com joins JSCore']);