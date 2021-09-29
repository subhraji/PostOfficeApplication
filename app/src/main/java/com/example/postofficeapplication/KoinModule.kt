
import com.example.postofficeapplication.model.repo.postOffice.PostOfficeRepository
import com.example.postofficeapplication.model.repo.postOffice.PostOfficeRepositoryImpl
import com.example.postofficeapplication.viewModel.PostOfficeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<PostOfficeRepository> { PostOfficeRepositoryImpl(get()) }
    viewModel { PostOfficeViewModel(get()) }
}