package com.plum.flow.presentation.tree

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plum.flow.domain.model.Fork
import com.plum.flow.utils.Resource


@Composable
fun ForkBranch(task: Fork?,viewModel:TreeViewModel= hiltViewModel()){
    val fork by remember {
        mutableStateOf(task)
    }
    var resChildren  by remember{
        mutableStateOf<Resource<List<Fork>?>>(Resource.Initial())
    }
    var children by remember{
        mutableStateOf(listOf<Fork>())
    }
    var display by rememberSaveable {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = fork) {
        viewModel.token.collect{
            fork?.run {
                if (it==null) {
                    viewModel.getForkChildren(this.id) {
                        resChildren = it
                    }
                }else{
                    viewModel.getProtectedForkChildren(this.id){

                        resChildren = it
                    }
                }
            }
        }
    }

    Column() {


        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp)
                )
                .clickable {
                    display = !display
                }
                .padding(top = 8.dp, start = 8.dp)

            ,verticalAlignment=Alignment.CenterVertically
        ) {
            Text(
                fork?.name ?: "Err",
                fontSize = 28.sp,
                modifier = Modifier.padding(start=16.dp,top=8.dp,bottom=8.dp)
            )
        }
        if(display){
        when(resChildren){
            is Resource.Error -> {
                Text("Error")
            }
            is Resource.Initial -> {
                Text("Initial")
            }
            is Resource.Loading -> {
                Text("Loading")
            }
            is Resource.Success -> {
                children = (resChildren as Resource.Success<List<Fork>?>).data?:listOf()
                Column(modifier=Modifier.padding(start=12.dp)) {
                    children.map { fork ->
                        ForkBranch(task = fork)
                    }
                }
            }
        }
    }}
}