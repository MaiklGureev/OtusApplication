package ru.gureev.otus_app.di.core

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gureev.otus_app.BuildConfig
import ru.gureev.otus_app.R
import ru.gureev.otus_app.utils.Constants
import ru.gureev.otus_app.utils.NullStringDeserializer
import java.io.IOException
import java.net.URLDecoder
import javax.inject.Singleton


@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClientInstance(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            addInterceptor(Interceptor { chain ->
                val original: Request = chain.request()

                // Настраиваем запросы
                val request: Request = original.newBuilder()
                    .header(Constants.BASE_KEY_HEADER, Constants.API_KEY)
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor = loggingInterceptor)
        }.build()

    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptorInstance(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            val level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }

            setLevel(level)
        }
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(
                String::class.java,
                object : TypeAdapter<String?>() {
                    @Throws(IOException::class)
                    override fun write(out: JsonWriter, value: String?) {
                        out.value(value)
                    }

                    @Throws(IOException::class)
                    override fun read(reader: JsonReader): String? {
                        val line = reader.nextString()
                        return URLDecoder.decode(line, "UTF-8")
                    }
                })
            .registerTypeAdapter(String::class.java, NullStringDeserializer())
            .create()
    }

}
