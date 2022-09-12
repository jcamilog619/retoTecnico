#language: es
Característica: Api Get
  Quiero validar la informacion del empleado en la api get de employee

  @datosEmpleados
  Esquema del escenario: Realizar la peticion para obener la informacion de un empleado
    Dado que el usuaro cargo los datos para el proceso
      | employee_name   | employee_salary   | employee_age   | employee_id   | date   |
      | <employee_name> | <employee_salary> | <employee_age> | <employee_id> | <date> |
    Cuando se realiza la consulta a la api
    Entonces se vizualizara exitosamente la informacion del response
    Ejemplos:
      | employee_name | employee_salary | employee_age | employee_id | date    |
      | Ashton Cox    | 86000           | 66           | 3           | exitoso |

  @valdacionApi
  Esquema del escenario: Realizar la peticion con el endpoint erronea
    Dado que el usuaro cargo los datos para el proceso
      | message   | date   |
      | <message> | <date> |
    Cuando se realiza la consulta a la api erronea
    Entonces se vizualizara el error del response
    Ejemplos:
      | message                                                         | date  |
      | Error Occured! Page Not found, contact rstapi2example@gmail.com | error |