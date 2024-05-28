package com.plum.flow.presentation.tree


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.plum.flow.domain.model.Fork
import com.plum.flow.utils.Resource

@Composable
fun TreeScreen(viewModel: TreeViewModel= hiltViewModel()) {
    var rootFork by rememberSaveable {
        mutableStateOf<Resource<Fork?>>(Resource.Initial())
    }
    var fork by remember{
        mutableStateOf<Fork?>(null)
    }
     LaunchedEffect(key1 = 0) {
       viewModel.getFocusFork {
           rootFork = it
         
       }
    }
    LazyColumn( horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color= Color(61,104,122)).fillMaxSize()
            .fillMaxWidth()){
        item {

            when (rootFork) {
                is Resource.Error -> {
                    Text("Error")
                    val res = rootFork as Resource.Error<String>
                    res.message?.run { Text(this) }
                }

                is Resource.Initial -> {
                    Text("Initial")
                }

                is Resource.Loading -> {
                    Text("Loading")
                }

                is Resource.Success -> {
                    fork = (rootFork as Resource.Success<Fork?>).data

                    ForkBranch(task = fork)

                }
            }
        }
    }
}