
ForoAlura
es una API REST desarrollada en Java con Spring Boot que replica el backend del foro de Alura Latam. Este proyecto permite la interacción entre estudiantes, profesores y moderadores mediante la creación, gestión y consulta de publicaciones.

📋 Características
Publicaciones
Crear nuevas publicaciones.
Consultar todas las publicaciones o una específica.
Actualizar y eliminar publicaciones.
Usuarios
Registro de usuarios.
Inicio y cierre de sesión.
Cambio de contraseña.
Gestión de roles (estudiante, profesor, moderador).
Seguridad
Autenticación y autorización con JSON Web Tokens (JWT).
Implementación de Refresh Tokens.
Autorización basada en roles y métodos.
Etiquetas y Categorías
Gestión de categorías y subcategorías para organizar las publicaciones.


🛠️ Tecnologías
Lenguaje: Java 17
Framework: Spring Boot
Seguridad: Spring Security 6, JWT
Base de Datos: MySQL
Gestión de dependencias: Maven


🚀 Configuración del Proyecto
1. Prerrequisitos
Java 17 instalado.
Maven instalado.
MySQL configurado.

2. Clonar el repositorio
bash
Copiar
Editar
git clone https://github.com/JhonF06/ForoAlura.git

3. Configurar la base de datos
Crear una base de datos en MySQL.
Actualizar las credenciales de la base de datos en el archivo application.properties.

4. Instalar dependencias
bash
Copiar
Editar
mvn install

5. Ejecutar la aplicación
bash
Copiar
Editar
mvn spring-boot:run
La API estará disponible en: http://localhost:8080


📚 Endpoints Principales

Autenticación
POST /auth/register: Registro de usuario.
POST /auth/login: Inicio de sesión.
POST /auth/logout: Cierre de sesión.
POST /auth/refresh-token: Generar nuevo token.

Publicaciones

POST /publicaciones: Crear una publicación.
GET /publicaciones: Listar todas las publicaciones.
GET /publicaciones/{id}: Consultar una publicación específica.
PUT /publicaciones/{id}: Actualizar una publicación.
DELETE /publicaciones/{id}: Eliminar una publicación.

Usuarios

GET /usuarios: Listar todos los usuarios.
PUT /usuarios/{id}/cambiar-contraseña: Cambiar contraseña.
PUT /usuarios/{id}/asignar-rol: Asignar rol a un usuario.
Categorías y Subcategorías
POST /categorias: Crear una categoría.
GET /categorias: Listar todas las categorías.
POST /subcategorias: Crear una subcategoría.
GET /subcategorias: Listar todas las subcategorías.

🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas realizar cambios, abre un issue para discutirlo antes de enviar un pull request.


📝 Licencia

Este proyecto está bajo la Licencia MIT.

Este proyecto es parte del Challenge Back End del programa Oracle Next Education en colaboración con Alura Latam.

