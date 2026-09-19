package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.credentials.provider.Action;
import androidx.credentials.provider.AuthenticationAction;
import androidx.credentials.provider.BeginGetCredentialRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CredentialEntry;
import androidx.credentials.provider.RemoteEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BeginGetCredentialUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil;", "", "<init>", "()V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BeginGetCredentialUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: BeginGetCredentialUtil.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u001e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015H\u0002J\u001e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015H\u0002J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¨\u0006$"}, d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil$Companion;", "", "<init>", "()V", "convertToJetpackRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "request", "Landroid/service/credentials/BeginGetCredentialRequest;", "convertToJetpackRequest$credentials", "convertToFrameworkResponse", "Landroid/service/credentials/BeginGetCredentialResponse;", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "populateRemoteEntry", "", "frameworkBuilder", "Landroid/service/credentials/BeginGetCredentialResponse$Builder;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "populateAuthenticationEntries", "authenticationActions", "", "Landroidx/credentials/provider/AuthenticationAction;", "populateActionEntries", "builder", "actionEntries", "Landroidx/credentials/provider/Action;", "populateCredentialEntries", "credentialEntries", "Landroidx/credentials/provider/CredentialEntry;", "convertToFrameworkRequest", "convertToJetpackBeginOption", "Landroid/service/credentials/BeginGetCredentialOption;", "option", "Landroidx/credentials/provider/BeginGetCredentialOption;", "convertToJetpackResponse", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$14(AuthenticationAction authenticationAction) {
            return authenticationAction != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$2(CredentialEntry credentialEntry) {
            return credentialEntry != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$8(Action action) {
            return action != null;
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginGetCredentialRequest convertToJetpackRequest$credentials(android.service.credentials.BeginGetCredentialRequest request) {
            CallingAppInfo callingAppInfoCreate;
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            List<BeginGetCredentialOption> beginGetCredentialOptions = request.getBeginGetCredentialOptions();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialOptions, "getBeginGetCredentialOptions(...)");
            for (BeginGetCredentialOption beginGetCredentialOption : beginGetCredentialOptions) {
                androidx.credentials.provider.BeginGetCredentialOption.Companion companion = androidx.credentials.provider.BeginGetCredentialOption.INSTANCE;
                String id = beginGetCredentialOption.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                String type = beginGetCredentialOption.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                Bundle candidateQueryData = beginGetCredentialOption.getCandidateQueryData();
                Intrinsics.checkNotNullExpressionValue(candidateQueryData, "getCandidateQueryData(...)");
                arrayList.add(companion.createFrom$credentials(id, type, candidateQueryData));
            }
            android.service.credentials.CallingAppInfo callingAppInfo = request.getCallingAppInfo();
            if (callingAppInfo != null) {
                CallingAppInfo.Companion companion2 = CallingAppInfo.INSTANCE;
                String packageName = callingAppInfo.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                SigningInfo signingInfo = callingAppInfo.getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "getSigningInfo(...)");
                callingAppInfoCreate = companion2.create(packageName, signingInfo, callingAppInfo.getOrigin());
            } else {
                callingAppInfoCreate = null;
            }
            return new BeginGetCredentialRequest(arrayList, callingAppInfoCreate);
        }

        public final BeginGetCredentialResponse convertToFrameworkResponse(androidx.credentials.provider.BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BeginGetCredentialResponse.Builder builder = new BeginGetCredentialResponse.Builder();
            populateCredentialEntries(builder, response.getCredentialEntries());
            populateActionEntries(builder, response.getActions());
            populateAuthenticationEntries(builder, response.getAuthenticationActions());
            populateRemoteEntry(builder, response.getRemoteEntry());
            BeginGetCredentialResponse beginGetCredentialResponseBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialResponseBuild, "build(...)");
            return beginGetCredentialResponseBuild;
        }

        private final void populateRemoteEntry(BeginGetCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            frameworkBuilder.setRemoteCredentialEntry(new android.service.credentials.RemoteEntry(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        private final void populateAuthenticationEntries(BeginGetCredentialResponse.Builder frameworkBuilder, List<AuthenticationAction> authenticationActions) {
            Iterator<T> it = authenticationActions.iterator();
            while (it.hasNext()) {
                frameworkBuilder.addAuthenticationAction(new android.service.credentials.Action(AuthenticationAction.INSTANCE.toSlice((AuthenticationAction) it.next())));
            }
        }

        private final void populateActionEntries(BeginGetCredentialResponse.Builder builder, List<Action> actionEntries) {
            Iterator<T> it = actionEntries.iterator();
            while (it.hasNext()) {
                builder.addAction(new android.service.credentials.Action(Action.INSTANCE.toSlice((Action) it.next())));
            }
        }

        private final void populateCredentialEntries(BeginGetCredentialResponse.Builder builder, List<? extends CredentialEntry> credentialEntries) {
            for (CredentialEntry credentialEntry : credentialEntries) {
                Slice slice$credentials = CredentialEntry.INSTANCE.toSlice$credentials(credentialEntry);
                if (slice$credentials != null) {
                    builder.addCredentialEntry(new android.service.credentials.CredentialEntry(new BeginGetCredentialOption(credentialEntry.getBeginGetCredentialOption().getId(), credentialEntry.getType(), Bundle.EMPTY), slice$credentials));
                }
            }
        }

        public final android.service.credentials.BeginGetCredentialRequest convertToFrameworkRequest(BeginGetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            android.service.credentials.BeginGetCredentialRequest.Builder builder = new android.service.credentials.BeginGetCredentialRequest.Builder();
            if (request.getCallingAppInfo() != null) {
                builder.setCallingAppInfo(new android.service.credentials.CallingAppInfo(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin()));
            }
            Stream<androidx.credentials.provider.BeginGetCredentialOption> stream = request.getBeginGetCredentialOptions().stream();
            final Function1 function1 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToFrameworkRequest$lambda$0((androidx.credentials.provider.BeginGetCredentialOption) obj);
                }
            };
            android.service.credentials.BeginGetCredentialRequest beginGetCredentialRequestBuild = builder.setBeginGetCredentialOptions((List) stream.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToFrameworkRequest$lambda$1(function1, obj);
                }
            }).collect(Collectors.toList())).build();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialRequestBuild, "build(...)");
            return beginGetCredentialRequestBuild;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BeginGetCredentialOption convertToFrameworkRequest$lambda$0(androidx.credentials.provider.BeginGetCredentialOption beginGetCredentialOption) {
            Companion companion = BeginGetCredentialUtil.INSTANCE;
            Intrinsics.checkNotNull(beginGetCredentialOption);
            return companion.convertToJetpackBeginOption(beginGetCredentialOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BeginGetCredentialOption convertToFrameworkRequest$lambda$1(Function1 function1, Object obj) {
            return (BeginGetCredentialOption) function1.invoke(obj);
        }

        private final BeginGetCredentialOption convertToJetpackBeginOption(androidx.credentials.provider.BeginGetCredentialOption option) {
            return new BeginGetCredentialOption(option.getId(), option.getType(), option.getCandidateQueryData());
        }

        public final androidx.credentials.provider.BeginGetCredentialResponse convertToJetpackResponse(BeginGetCredentialResponse response) {
            RemoteEntry remoteEntryFromSlice;
            Intrinsics.checkNotNullParameter(response, "response");
            Stream<android.service.credentials.CredentialEntry> stream = response.getCredentialEntries().stream();
            final Function1 function1 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$0((android.service.credentials.CredentialEntry) obj);
                }
            };
            Stream<R> map = stream.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda19
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$1(function1, obj);
                }
            });
            final Function1 function2 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$2((CredentialEntry) obj));
                }
            };
            Stream streamFilter = map.filter(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$3(function2, obj);
                }
            });
            final Function1 function3 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$4((CredentialEntry) obj);
                }
            };
            Object objCollect = streamFilter.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$5(function3, obj);
                }
            }).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect, "collect(...)");
            List list = (List) objCollect;
            Stream<android.service.credentials.Action> stream2 = response.getActions().stream();
            final Function1 function4 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$6((android.service.credentials.Action) obj);
                }
            };
            Stream<R> map2 = stream2.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$7(function4, obj);
                }
            });
            final Function1 function5 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$8((Action) obj));
                }
            };
            Stream streamFilter2 = map2.filter(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda8
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$9(function5, obj);
                }
            });
            final Function1 function6 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$10((Action) obj);
                }
            };
            Object objCollect2 = streamFilter2.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda12
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$11(function6, obj);
                }
            }).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect2, "collect(...)");
            List list2 = (List) objCollect2;
            Stream<android.service.credentials.Action> stream3 = response.getAuthenticationActions().stream();
            final Function1 function7 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$12((android.service.credentials.Action) obj);
                }
            };
            Stream<R> map3 = stream3.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda14
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$13(function7, obj);
                }
            });
            final Function1 function8 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$14((AuthenticationAction) obj));
                }
            };
            Stream streamFilter3 = map3.filter(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda16
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$15(function8, obj);
                }
            });
            final Function1 function9 = new Function1() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$16((AuthenticationAction) obj);
                }
            };
            Object objCollect3 = streamFilter3.map(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda18
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$17(function9, obj);
                }
            }).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect3, "collect(...)");
            List list3 = (List) objCollect3;
            android.service.credentials.RemoteEntry remoteCredentialEntry = response.getRemoteCredentialEntry();
            if (remoteCredentialEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                Slice slice = remoteCredentialEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
                remoteEntryFromSlice = companion.fromSlice(slice);
            } else {
                remoteEntryFromSlice = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialResponse(list, list2, list3, remoteEntryFromSlice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$0(android.service.credentials.CredentialEntry credentialEntry) {
            CredentialEntry.Companion companion = CredentialEntry.INSTANCE;
            Slice slice = credentialEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
            return companion.fromSlice$credentials(slice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$1(Function1 function1, Object obj) {
            return (CredentialEntry) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$3(Function1 function1, Object obj) {
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$4(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNull(credentialEntry);
            return credentialEntry;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$5(Function1 function1, Object obj) {
            return (CredentialEntry) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$6(android.service.credentials.Action action) {
            Action.Companion companion = Action.INSTANCE;
            Slice slice = action.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
            return companion.fromSlice(slice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$7(Function1 function1, Object obj) {
            return (Action) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$9(Function1 function1, Object obj) {
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$10(Action action) {
            Intrinsics.checkNotNull(action);
            return action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$11(Function1 function1, Object obj) {
            return (Action) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$12(android.service.credentials.Action action) {
            AuthenticationAction.Companion companion = AuthenticationAction.INSTANCE;
            Slice slice = action.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
            return companion.fromSlice(slice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$13(Function1 function1, Object obj) {
            return (AuthenticationAction) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$15(Function1 function1, Object obj) {
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$16(AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNull(authenticationAction);
            return authenticationAction;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$17(Function1 function1, Object obj) {
            return (AuthenticationAction) function1.invoke(obj);
        }
    }
}
