package org.ghostinthesuhi.android.efficio.network

/**
 * For now, just documentation. Might be cool to do something with this?
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class ExpectedError(val code: Int, val explanation: String)