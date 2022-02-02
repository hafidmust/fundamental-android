package com.hafidmust.myunittest

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun setUp() {
        cuboidModel = mock(CuboidModel::class.java)
        viewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val circumFerence = viewModel.getCircumference()
        assertEquals(dummyCircumference, circumFerence, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = viewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = viewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}