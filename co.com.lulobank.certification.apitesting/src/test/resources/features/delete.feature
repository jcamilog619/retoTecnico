#language: es
Característica: Api delete
  Quiero eliminar la informacion del empleado del api delete

  @datosEmpleados
  Esquema del escenario: Realizar la eliminacion de un empleado
    Dado que el usuaro cargo los datos para el proceso
      | employee_name   | employee_salary   | employee_age   |
      | <employee_name> | <employee_salary> | <employee_age> |
    Cuando se realiza la creacion del empleado en la api
    Y elimino la informacion del empleado
    Entonces se vizualizara exitosamente la eliminacion del empleado
    Ejemplos:
      | employee_name        | employee_salary | employee_age |
      | Juan Camilo | 86000  | 66  |
