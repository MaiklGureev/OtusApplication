package ru.gureev.core.common

interface IMapper<in From : Any?, out To : Any?> {
    fun convert(from: From): To
    fun <P : Any> convertWithParams(from: From, params: P): To? = null
}

fun <From : Any, To : Any> IMapper<From, To>.convertList(fromItems: List<From>?): List<To> {
    return fromItems?.map { convert(it) }.orEmpty()
}

interface IMapperWithParams<in From : Any?, Params : Any?, out To : Any?> {
    fun convertWithParams(from: From, params: Params): To
}

fun <From : Any, Params : Any?, To : Any> IMapperWithParams<From, Params, To>.convertListWithParams(
    fromItems: List<From>?,
    params: Params
): List<To> {
    return fromItems?.map { convertWithParams(it, params) }.orEmpty()
}
