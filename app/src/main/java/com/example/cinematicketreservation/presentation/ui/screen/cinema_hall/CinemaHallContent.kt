package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematicketreservation.presentation.ui.component.CloseIcon
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical16Dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical24Dp
import com.example.cinematicketreservation.presentation.ui.screen.movie_details.DaySelectBottomSheet
import com.example.cinematicketreservation.presentation.viewModel.CinemaHallViewModel

@Composable
fun CinemaHallScreen(
    viewModel: CinemaHallViewModel = hiltViewModel(),
    navController: NavController
) {
    val movie = viewModel.state.collectAsState().value
    CinemaHallContent(
        onClickClose = { navController.popBackStack() },
        backDropImageRes = movie.movieBackDropImageRes
    )
}


@Composable
fun CinemaHallContent(onClickClose: () -> Unit, @DrawableRes backDropImageRes: Int) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            SpacerVertical16Dp()
            CloseIcon(Modifier.clickable { onClickClose() })
            CinemaProjector(backDropImageRes)
            SeatsSection()
            SpacerVertical24Dp()
            SeatIndicatorSection()
            SpacerVertical24Dp()
        }
        Box(Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))) {
            DaySelectBottomSheet()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CinemaHallPreview() {
    CinemaHallContent({},0)
}