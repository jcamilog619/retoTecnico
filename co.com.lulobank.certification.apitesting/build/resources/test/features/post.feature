#language: es
Característica: Api Post
  Quiero crer la informacion del empleado en la api post create

  @datosEmpleados
  Esquema del escenario: Realizar la creacion de un empleado
    Dado que el usuaro cargo los datos para el proceso
      | employee_name   | employee_salary   | employee_age   |
      | <employee_name> | <employee_salary> | <employee_age> |
    Cuando se realiza la creacion en la api
    Entonces se vizualizara exitosamente la creacion del empleado
    Ejemplos:
      | employee_name        | employee_salary | employee_age |
      | Juan Camilo | 86000  | 66  |
