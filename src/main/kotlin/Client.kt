import kotlinx.browser.document
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.redux.Provider
import redux.store.HelloWorldStore

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

    val appStore = HelloWorldStore()


    val welcome = Fragment.create {
        Provider() {
            store = appStore

            Feature {}
        }

    }
    createRoot(container).render(welcome)
}