package ru.gureev.otus_app.di.core

import dagger.Binds
import dagger.Module
import ru.gureev.core.resources.IColorResources
import ru.gureev.core.resources.IDrawableResources
import ru.gureev.core.resources.IStringResources
import ru.gureev.otus_app.resources.StringResources


@Module(includes = [AppModule.DataBinds::class])
class AppModule {


    @Module
    interface DataBinds {

        @Binds
        fun bindsStringResources(value: StringResources): IStringResources

        @Binds
        fun bindsDrawableResources(value: IDrawableResources): IDrawableResources


        @Binds
        fun bindsColorResources(value: IColorResources): IColorResources

    }
}
