package Com_company.ohgiraffers_department.model.DTO;

public class DepartmentDTO implements java.io.Serializable {

    /*
     * TBL_MENU TABLE <-> MenuDTO
     * EMP_ID <-> empid
     * EMP_NAME <-> empname
     * EMP_No <-> empno
     * JOB_CODE <-> jobCode
     * SAL_LEVEL <-> salLevel
     */

    private String empId;
    private String empName;
    private String empNo;

    private String jobCode;

    private String salLevel;

    public DepartmentDTO() { } //기본생성자 생성
    public DepartmentDTO(String id,String name, String number) {
        this.empId = id;
        this.empName = name;
        this.empNo = number;
    }

    public DepartmentDTO(String empId, String empName, String empNo, String jobCode, String salLevel) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                '}';
    }
}
