package com.hanyeop.songforyou.usecase.song

import com.hanyeop.songforyou.repository.SongRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSongDetailUseCase @Inject constructor(
    private val songRepository: SongRepository
) {
    fun execute(songSeq: Int) = songRepository.getSongDetail(songSeq)
}