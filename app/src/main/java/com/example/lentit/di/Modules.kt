package com.example.lentit.di

import com.example.lentit.ui.home.HomeViewModel
import com.example.lentit.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Modules = module {
    viewModel { HomeViewModel() }
    viewModel { NotificationsViewModel() }
}