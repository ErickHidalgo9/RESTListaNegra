# Proyecto Final
## RESTListaNegra

Para coordinar acciones de respuesta ante fraudes, es útil tener disponible información contextual del lugar de origen detectado en el momento de comprar, buscar y pagar. Para ello se decide crear una herramienta que dada una IP obtenga información asociada.

- El ejercicio consiste en construir una API Rest que permita:
  1. Dada una dirección IP, encontrar el país al que pertenece y mostrar:
      - El nombre y código ISO del país
      - Moneda local y su cotización actual en dólares o euros.
  2. Ban/Blacklist de una IP: marcar la IP en una lista negra no permitiéndole consultar la información del punto 1

- Observaciones: 
  - Tener en cuenta que el punto 1 puede recibir fluctuaciones agresivas de tráfico.

- Para obtener la información, pueden utilizarse las siguientes APIs públicas:
  - Geolocalización de IPs: https://ip2country.info/
  - Información de paises: http://restcountries.eu/
  - Información sobre monedas: http//fixer.io/

## Ejecucion

- Para ejecutar la REST API:
  1. Levantar EurekaServer
  2. Posteriormente levantar la RESTListaNegra
  3. Al final levantar el GatewayServer

- Los endpoints para ejecutar en POSTMAN son los siguientes:
  - Consultar ip: http://localhost:8090/restfraudes/api/v1/api-fraude/ip-informacion/131.72.212.0 
  - Banear ip: http://localhost:8090/restfraudes/api/v1/api-fraude/ip-baneada/131.72.212.0

- Se puede visitar la Base de datos en memoria H2 una vez estando en ejecucion la REST API en el siguiente enlace: http://localhost:8090/restfraudes/api/v1/api-fraude/h2-console
  - UserName: sa
  - Password: sa


![BD en memoria](https://user-images.githubusercontent.com/99521248/156703301-f8d3c226-1f68-4557-9f84-b09c2934177b.png)
