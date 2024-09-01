import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

// instância que estabelece a conexão com o banco de dados
// nota: o object é uma forma de dizer que haverá apenas uma única instância de determinada classe
object Banco {
//    fun obterConexao(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "root")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }
    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}