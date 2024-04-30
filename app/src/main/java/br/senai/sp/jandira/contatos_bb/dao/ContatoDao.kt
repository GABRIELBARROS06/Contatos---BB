package br.senai.sp.jandira.contatos_bb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import br.senai.sp.jandira.contatos_bb.model.Contato
import androidx.room.Query

@Dao
interface ContatoDao {

@Insert
fun salvar(contato: Contato)

@Update
fun atualizar(contato: Contato)

@Delete
fun deletar(contato: Contato)

@Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
fun listarTodosOsCont():List<Contato>

@Query("SELECT * FROM tbl_contatos WHERE nome = :nome ORDER BY NOME ASC")
fun buscarContatoPeloNome(nome: String): List<Contato>


}