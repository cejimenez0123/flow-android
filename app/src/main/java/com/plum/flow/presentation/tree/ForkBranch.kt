package com.plum.flow.presentation.tree

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.plum.flow.domain.model.Fork


@Composable
fun ForkBranch(fork: Fork){
    
    
    Text( fork.name )
}