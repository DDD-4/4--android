package com.ddd4.domain.usecases.usecase

import com.ddd4.domain.entity.DomainModel
import com.ddd4.domain.repository.DropitRepository
import com.ddd4.domain.usecases.BaseUseCase

interface GetDummyUseCase: BaseUseCase {
    suspend operator fun invoke(domainModel: DomainModel)
}
