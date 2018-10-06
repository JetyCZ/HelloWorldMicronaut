package helloworld

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.BeforeClass
import org.junit.Test

class HelloControllerTest {

    companion object {

        private lateinit var server: EmbeddedServer
        private lateinit var client: HttpClient

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            server = ApplicationContext.run(EmbeddedServer::class.java);
            client = server.applicationContext.createBean(HttpClient::class.java, server.url);

        }
        @AfterClass
        @JvmStatic
        fun afterClass() {
            server.stop()
            client.stop()
        }
    }

    @Test
    fun startup() {}

    @Test
    fun hello() {
        val request:HttpRequest<Any> = HttpRequest.GET("/hello/pavel?greeting=fo")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals(
                body,
                "fo pavel"
        )
    }

    @Test
    fun hello5() {
        val request:HttpRequest<Any> = HttpRequest.GET("/hello/pavel?greeting=fo")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals(
                body,
                "fo pavel"
        )
    }
    @Test
    fun index() {
        val request:HttpRequest<Any> = HttpRequest.GET("/index")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals(
                body,
                "bla"
        )
    }
}