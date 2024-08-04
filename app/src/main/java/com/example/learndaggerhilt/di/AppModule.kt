package com.example.learndaggerhilt.di

import android.content.Context
import com.example.learndaggerhilt.data.RemoteApi
import com.example.learndaggerhilt.data.RemoteRepositoryImpl
import com.example.learndaggerhilt.domain.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named("baseUrlV1")
    @Singleton
    fun provideBaseUrlV1(): String = "https://api-v1.example.com"

    @Provides
    @Named("baseUrlV2")
    @Singleton
    fun provideBaseUrlV2(): String = "https://api-v2.example.com"

    @Provides
    @Named("welcomeText")
    @Singleton
    fun provideWelcomeText(): String = "Welcome to this App!"

    @Provides
    @Singleton
    fun provideRemoteApi(@Named("baseUrlV2") baseUrl: String): RemoteApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .build()
            .create(RemoteApi::class.java)
    }

    /**
     * we can also provide implementation classes as below
     */
//    @Provides
//    @Singleton
//    fun provideRemoteRepository(remoteApi: RemoteApi, @ApplicationContext context: Context): RemoteRepository {
//        return RemoteRepositoryImpl(remoteApi, context)
//    }
}