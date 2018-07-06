package com.fastaccess.data.repository

import androidx.lifecycle.LiveData
import com.fastaccess.data.persistence.dao.NotificationsDao
import com.fastaccess.data.persistence.models.NotificationModel
import javax.inject.Inject

/**
 * Created by Kosh on 22.06.18.
 */
class NotificationRepositoryProvider @Inject constructor(private val dao: NotificationsDao) : NotificationRepository {
    override fun getNotifications(login: String): LiveData<List<NotificationModel>> = dao.getNotifications(login)
    override fun getMainNotifications(login: String): LiveData<List<NotificationModel>> = dao.getMainNotifications(login)
    override fun insert(model: NotificationModel): Long = dao.insert(model)
    override fun insert(model: List<NotificationModel>) = dao.insert(model)
    override fun update(model: NotificationModel): Int = dao.update(model)
    override fun delete(model: NotificationModel) = dao.delete(model)
    override fun deleteAll() = dao.deleteAll()
}

interface NotificationRepository {
    fun getNotifications(login: String): LiveData<List<NotificationModel>>
    fun getMainNotifications(login: String): LiveData<List<NotificationModel>>
    fun insert(model: NotificationModel): Long
    fun insert(model: List<NotificationModel>)
    fun update(model: NotificationModel): Int
    fun delete(model: NotificationModel)
    fun deleteAll()
}