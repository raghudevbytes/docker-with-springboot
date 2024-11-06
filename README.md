# docker-with-springboot
<h3>This is a simple spring boot application, run by using Docker</h3>
<hr/>
<p>
  <code>Docker</code> is a tool that helps developers build, package, and run applications in a standardized way across different environments. It achieves this by using <code>containers</code>, which are lightweight, standalone, and portable units that bundle an application along with its dependencies (like libraries and settings).

</p>
<h3>Dockerfile</h3>
<code>
ARG version=17-slim-buster
FROM openjdk:${version}
LABEL maintainer="tester@gmail.com"
WORKDIR /usr/src
COPY target/user-1.0.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","user-1.0.jar"]
</code>
<hr/>

  <ul>
<li><B>FROM</B> <code>openjdk:${version}</code>: Uses an official OpenJDK base image, where ${version} should be replaced with the desired Java version (e.g., 11, 17).</li>

<li><B>LABEL</B> <code>maintainer="tester@gmail.com"</code>: Adds metadata to the image, specifying the maintainer's contact information.</li>

<li><B>WORKDIR </B><code>/usr/src</code>: Sets the working directory inside the container to /usr/src; all subsequent commands will be run here.</li>

<li><B>COPY</B> <code>target/user-1.0.jar .</code>: Copies the user-1.0.jar file from the target directory on the host machine to the current working directory in the container.</li>

<li><B>EXPOSE</B> <code>8080</code>: Informs Docker that the container will use port 8080, allowing this port to be mapped when the container runs.</li>

<li><B>ENTRYPOINT</B> <code>["java","-jar","user-1.0.jar"]</code>: Specifies the command to run when the container starts, launching the Java application from the user-1.0.jar file.</li>
</ul>
<hr/>
<body>

<h3>Issues Encountered When Accessing Endpoints Locally</h3>

<p>1. Initially, when trying to access the endpoint, I received a "server not connected" error. To resolve this, ensure that the application’s running port matches the <code>EXPOSE</code> port in the Dockerfile.</p>

<p>2. After correcting the port, I encountered a 404 error. This was due to an incorrect endpoint specified in the <code>@RequestMapping</code> annotation within the <code>@RestController</code>. I mistakenly set it to <code>/api/v1</code>, when it should have been <code>api/v1</code> without the leading slash.</p>

</body>
