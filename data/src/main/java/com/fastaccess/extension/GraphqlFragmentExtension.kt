package com.fastaccess.extension

import com.fastaccess.data.model.*
import com.fastaccess.data.persistence.models.MyIssuesPullsModel
import github.fragment.*

/**
 * Created by Kosh on 05.02.19.
 */


fun ShortActor.toUser(): ShortUserModel = ShortUserModel(login, login, url.toString(), avatarUrl = avatarUrl.toString())

fun ShortPullRequestRowItem.toPullRequest(): MyIssuesPullsModel = MyIssuesPullsModel(id, databaseId, number,
    title, repository.nameWithOwner, comments.totalCount,
    state.rawValue(), url.toString())

fun ShortIssueRowItem.toIssue(): MyIssuesPullsModel = MyIssuesPullsModel(id, databaseId, number,
    title, repository.nameWithOwner, comments.totalCount, "", url.toString())

fun CommitFragment.toCommit(): CommitModel = CommitModel(id,
    ShortUserModel(author?.name, author?.name, avatarUrl = author?.avatarUrl?.toString()), message,
    abbreviatedOid, oid.toString(), commitUrl.toString(), authoredDate, isCommittedViaWeb)

fun Reactions.toReactionGroup(): ReactionGroupModel = ReactionGroupModel(ReactionContent.getByValue(this.content.rawValue()),
    this.createdAt, CountModel(this.users.totalCount), this.isViewerHasReacted)