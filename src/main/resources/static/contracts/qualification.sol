pragma solidity ^0.4.0;
contract qualification {

    address owner;

    /* This function is executed at initialization and sets the owner of the contract */
    function qualification() { owner = msg.sender; }

    /* Function to recover the funds on the contract */
    function kill() { if (msg.sender == owner) selfdestruct(owner); }

}


contract credentials is qualification {

        string studentName;
        string studentEmail;
        string studentUniversity;
        string studentCourse;
        string studentStart;
        string studentEnd;
        string studentClassification;


    /* This runs when the contract is executed */
    function credentials(string _name, string _email, string _university, string _course, string _start, string _end, string _classification) public {
        studentName = _name;
        studentEmail = _email;
        studentUniversity = _university;
        studentCourse = _course;
        studentStart = _start;
        studentEnd = _end;
        studentClassification = _classification;
    }

    /* Main function */
    function returnQualification() constant returns (string, string, string, string, string, string, string) {
        return (studentName, studentEmail, studentUniversity, studentCourse, studentStart, studentEnd, studentClassification);
    }
}