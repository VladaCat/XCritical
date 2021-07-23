package com.example.xcriticalapp.common
import com.example.xcriticalapp.retrofit.RetrofitServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

object Common {
    @Module
    @InstallIn(SingletonComponent::class)
    object Network {
        @Singleton
        @Provides
        fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl("https://www.simplifiedcoding.net/demos/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        @Singleton
        @Provides
        fun provideMoshi(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        @Provides
        fun provideService(retrofit: Retrofit): RetrofitServices = retrofit.create(RetrofitServices::class.java)
    }
}