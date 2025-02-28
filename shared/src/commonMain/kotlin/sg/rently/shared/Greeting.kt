package sg.rently.shared

import org.koin.core.context.startKoin
import sg.rently.shared.di.appModule
import sg.rently.shared.di.networkModule

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun init(){
        startKoin {
            modules(appModule)
            modules(networkModule)
        }
    }
}