package com.clearscore.donutview.backend.models

import java.io.Serializable

data class DonutDataModel (
    override var isSuccessful: Boolean = false,
    override var message: String = "",
    val accountIDVStatus: String,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String,
    val coachingSummary: CoachingSummary,
    val augmentedCreditScore: Object //raw JSON response shows null, not sure of the structure here

) : BaseDataModel(), Serializable

data class CreditReportInfo (
    val score: Float,
    val scoreBand: Int,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Float,
    val minScoreValue: Int,
    val monthsSinceLastDefaulted: Int,
    val hasEverDefaulted: Boolean,
    val monthsSinceLastDelinquent: Int,
    val hasEverBeenDelinquent: Boolean,
    val percentageCreditUsed: Int,
    val percentageCreditUsedDirectionFlag: Int,
    val changedScore: Int,
    val currentShortTermDebt: Int,
    val currentShortTermNonPromotionalDebt: Int,
    val currentShortTermCreditLimit: Int,
    val currentShortTermCreditUtilisation: Int,
    val changeInShortTermDebt: Int,
    val currentLongTermDebt: Int,
    val currentLongTermNonPromotionalDebt: Int,
    val currentLongTermCreditLimit: Int,
    val currentLongTermCreditUtilisation: Int,
    val changeInLongTermDebt: Int,
    val numPositiveScoreFactors: Int,
    val numNegativeScoreFactors: Int,
    val equifaxScoreBand: Int,
    val equifaxScoreBandDescription: String,
    val daysUntilNextReport: Int,
) : Serializable

data class CoachingSummary (
    val activeTodo: Boolean,
    val activeChat: Boolean,
    val numberOfTodoItems: Int,
    val numberOfCompletedTodoItems: Int,
    val selected: Boolean,
) : Serializable