package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import domain.model.MjImages
import util.OnBottomReached

@OptIn(ExperimentalFoundationApi::class)
@Composable
actual fun PlatformSpecificMjImagesGrid(
    onLoadMore: () -> Unit,
    images: MjImages,
    modifier: Modifier,
) {
    LazyVerticalStaggeredGrid(
        state = rememberLazyStaggeredGridState().apply {
            OnBottomReached(onLoadMore::invoke)
        },
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier,
    ) {
        items(
            images.images,
        ) { image ->
            MjImageItem(
                image,
                // (180 * image.ratio).dp,
                220.dp,
                ContentScale.Crop
            )
        }
    }
}
