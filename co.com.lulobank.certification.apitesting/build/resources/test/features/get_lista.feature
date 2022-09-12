#language: es
Característica: Api Get lista
  Quiero validar la informacion de los empleados del api get de employees

  @datosEmpleados
  Esquema del escenario: Realizar la peticion para obener la informacion del empleado
    Dado que el usuaro cargo los datos para el proceso
      | employee_name   | employee_salary   | employee_age   | employee_id   | date   |
      | <employee_name> | <employee_salary> | <employee_age> | <employee_id> | <date> |
    Cuando se realiza la peticion a la api
    Entonces se vizualizara exitosamente el response
    Ejemplos:
      | employee_name | employee_salary | employee_age | employee_id | date    |
      | Cedric Kelly  | 433060          | 22           | 3           | exitoso |

  @valdacionApi
  Esquema del escenario: Realizar la peticion con el endpoint erroneo
    Dado que el usuaro cargo los datos para el proceso
      | message   | date   |
      | <message> | <date> |
    Cuando se realiza la peticion a la api erronea
    Entonces se vizualizara el error en el response
    Ejemplos:
      | message                                                         | date  |
      | Error Occured! Page Not found, contact rstapi2example@gmail.com | error |