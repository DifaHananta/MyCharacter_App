package com.dicoding.jetmycharacter.di

import com.dicoding.jetmycharacter.data.CharacterRepository

object Injection {
    fun provideRepository(): CharacterRepository {
        return CharacterRepository.getInstance()
    }
}