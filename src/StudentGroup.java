
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException {
		if(students == null) {
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		checkIndex(index);
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		checkIndex(index);
		checkStudent(student);
		this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		checkStudent(student);
		Student[] modifiedGroup = new Student[this.students.length + 1];
		modifiedGroup[0] = student;
		for(int i = 0; i < this.students.length; i++) {
			modifiedGroup[i+1] = this.students[i];
		}
		this.students = modifiedGroup;
	}

	@Override
	public void addLast(Student student) {
		checkStudent(student);
		Student[] modifiedGroup = new Student[this.students.length + 1];
		modifiedGroup[modifiedGroup.length - 1] = student;
		for(int i = 0; i < this.students.length; i++) {
			modifiedGroup[i] = this.students[i];
		}
		this.students = modifiedGroup;
	}

	@Override
	public void add(Student student, int index) {
		checkIndex(index);
		checkStudent(student);
		Student[] modifiedGroup = new Student[this.students.length + 1];
		modifiedGroup[index] = student;
		for(int i = 0; i < index; i++) {
			modifiedGroup[i] = this.students[i];
        }
        for(int j = index + 1; j < modifiedGroup.length; j++) {
        	modifiedGroup[j] = this.students[j-1];
        }
        this.students = modifiedGroup;
	}

	@Override
	public void remove(int index) {
		checkIndex(index);
		Student[] modifiedGroup = new Student[this.students.length - 1];
		for(int i = 0; i < index; i++) {
			modifiedGroup[i] = this.students[i];
		}
		for(int j = index+1; j < this.students.length; j++) {
			modifiedGroup[j - 1] = this.students[j];
		}
		this.students = modifiedGroup;
	}

	@Override
	public void remove(Student student) {
		checkStudent(student);
		int index = getIndexOfElement(student);
		remove(index);
	}

	@Override
	public void removeFromIndex(int index) {
		checkIndex(index);
		Student[] modifiedGroup = new Student[index + 1];
		for(int i =0 ; i <= index; i++) {
			modifiedGroup[i] = this.students[i];
		}
		this.students = modifiedGroup;
	}

	@Override
	public void removeFromElement(Student student) {
		checkStudent(student);
		int index = getIndexOfElement(student);
		removeFromIndex(index);
	}

	@Override
	public void removeToIndex(int index) {
		checkIndex(index);
		Student[] modifiedGroup = new Student[this.students.length - index];
		for(int i = 0 ; i <= modifiedGroup.length; i++) {
			modifiedGroup[i] = this.students[index + i];
		}
		this.students = modifiedGroup;
	}

	@Override
	public void removeToElement(Student student) {
		checkStudent(student);
		int index = getIndexOfElement(student);
		removeToIndex(index);
	}

	@Override
	public void bubbleSort() {
		int n = this.students.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (this.students[j].getId() > this.students[j + 1].getId()) {
					Student temp = this.students[j];
					this.students[j] = this.students[j + 1];
					this.students[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
	
	private void checkIndex(int index) {
		if(index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		}
	}
	
	private void checkStudent(Student student) {
		if(student == null) {
			throw new IllegalArgumentException();
		}
	}
	
	private int getIndexOfElement(Student student) {
		int index = -1;
		for(int i = 0; i < this.students.length; i++) {
			if(this.students[i].equals(student)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			throw new IllegalArgumentException("Student does not exist");
		}
		return index;
	}
}


