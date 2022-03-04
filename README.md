# Proyecto Final
## RESTListaNegra

Para coordinar acciones de respuesta ante fraudes, es útil tener disponible información contextual del lugar de origen detectado en el momento de comprar, buscar y pagar. Para ello se decide crear una herramienta que dada una IP obtenga información asociada.

- El ejercicio consiste en construir una API Rest que permita:
  1. Dada una dirección IP, encontrar el país al que pertenece y mostrar:
      - El nombre y código ISO del país
      - Moneda local y su cotización actual en dólares o euros.
  2. Ban/Blacklist de una IP: marcar la IP en una lista negra no permitiéndole consultar la información del punto 1
