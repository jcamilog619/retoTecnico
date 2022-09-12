package co.com.certification.enums;

public enum EndPoint {
    ENDPOINT("http://dummy.restapiexample.com/api/v1/employee/"),
    ENDPOINT_ERROR("http://dummy.restapiexample.com/api/v1/employeeE/"),
    ENDPOINT_LISTA("http://dummy.restapiexample.com/api/v1/employees"),
    ENDPOINT_LISTA_ERROR("http://dummy.restapiexample.com/api/v1/employeess"),
    ENDPOINT_CREAR("http://dummy.restapiexample.com/api/v1/create"),
    ENDPOINT_DELETE("http://dummy.restapiexample.com/api/v1/delete/");
    private final String toString;

    EndPoint(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}
