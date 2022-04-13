# Clean Architecture

### Ideas Principales
* Estructurar código en capas contiguas
* Cada capa se comunica solo con las adyacentes

* Capas principales en clean architecture:
  * Capa de Proveedores de datos -> acceso a ddbb, etc..
  * Capa entidades → Lógica de negocio
  * Capa casos de uso → Lógica de aplicación (listar entidad x, ...)
  * Capa controladores -> comunicarse vs ddbb, presentar info en ui, renderizar html, etc
  * Capa de lo demás


### Ventajas
* Modularidad → Mayor reusabilidad del código
* Bajo acoplamiento