package org.example
// classe criada para obtenção das chaves contidas dentro de "info"
data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}