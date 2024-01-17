package com.dicoding.jetmycharacter.data

import com.dicoding.jetmycharacter.model.CharactersData
import com.dicoding.jetmycharacter.model.OrderCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CharacterRepository {

    private val orderCharacters = mutableListOf<OrderCharacter>()

    init {
        if (orderCharacters.isEmpty()) {
            CharactersData.dummyCharacters.forEach {
                orderCharacters.add(OrderCharacter(it, 0))
            }
        }
    }

    fun getAllCharacters(): Flow<List<OrderCharacter>> {
        return flowOf(orderCharacters)
    }

    fun getOrderCharacterById(characterId: Long): OrderCharacter {
        return orderCharacters.first {
            it.character.id == characterId
        }
    }

    companion object {
        @Volatile
        private var instance: CharacterRepository? = null

        fun getInstance(): CharacterRepository =
            instance ?: synchronized(this) {
                CharacterRepository().apply {
                    instance = this
                }
            }
    }
}