<h1>Wiremock</h1>
Berikut adalah project mocking API menggunakan wiremock, disini juga dibuat API testing untuk request GET, POST, PUT, DELETE.

<h2>Tutorial</h2>
<li> Download file jar wiremock di link berikut </br> https://wiremock.org/docs/download-and-installation/ </br></br></li>
<li> Jalankan di commandline dengan perintah berikut</li>

```
java -jar wiremock-standalone-3.4.1.jar --port 8080 --verbose
```
<li> Buat file stubbing untuk mapping setiap request (GET,POST,PUT,DELETE) pada folder mappings </li>
<li> Buat file json untuk response body pada folder __files (jika body response perlu memanggil file)</li>
<li> Cek apakah mock server sudah berjalan dengan baik (bisa dengan postman)</li>
<li>Mock server sudah dapat digunakan untuk testing</li>
</br>
Link youtube : https://youtu.be/tVgPigX_jng
