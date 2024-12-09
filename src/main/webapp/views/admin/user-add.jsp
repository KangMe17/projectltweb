<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="page-user"></div>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Add user <small>add user here</small>
				</h1>
			</div>
			<!-- END PAGE TITLE -->
		</div>
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row margin-top-10">
				<div class="col-md-12">
					<!-- BEGIN PROFILE SIDEBAR -->
					<div class="profile-sidebar" style="width: 250px;">
						<!-- PORTLET MAIN -->
						<div class="portlet light profile-sidebar-portlet">
							<!-- SIDEBAR USERPIC -->
							<div class="profile-userpic">
								<img
									src="${URL}assets/admin/pages/media/profile/profile_user.jpg"
									class="img-responsive" alt="">
							</div>
							<!-- END SIDEBAR USERPIC -->
							<!-- SIDEBAR USER TITLE -->
							<div class="profile-usertitle">
								<div class="profile-usertitle-name">${user.firstname}
									${user.lastname}</div>
								<div class="profile-usertitle-job">${user.role}</div>
							</div>
							<!-- END SIDEBAR USER TITLE -->
							<!-- SIDEBAR BUTTONS -->
							<div class="profile-userbuttons">
								<button type="button" class="btn btn-circle green-haze btn-sm">Follow</button>
								<button type="button" class="btn btn-circle btn-danger btn-sm">Message</button>
							</div>
							<!-- END SIDEBAR BUTTONS -->
							
						</div>
						<!-- END PORTLET MAIN -->
					</div>
					<!-- END BEGIN PROFILE SIDEBAR -->
					<!-- BEGIN PROFILE CONTENT -->
					<div class="profile-content">
						<div class="row">
							<div class="col-md-12">
								<div class="portlet light">
									<div class="portlet-title tabbable-line">
										<div class="caption caption-md">
											<i class="icon-globe theme-font hide"></i> <span
												class="caption-subject font-blue-madison bold uppercase">Profile
												Account</span>
										</div>
										<ul class="nav nav-tabs">
											<li class="active"><a href="#tab_1_1" data-toggle="tab">Personal
													Info</a></li>
										</ul>
									</div>
									<div class="portlet-body">
										<div class="tab-content">
											<!-- PERSONAL INFO TAB -->
											<div class="tab-pane active" id="tab_1_1">
												<form role="form" action="#">
													<div class="form-group">
														<label class="control-label">First Name</label> <input
															type="text" value="${user.firstname}"
															class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">Last Name</label> <input
															type="text" value="${user.lastname}" class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">Phone</label> <input
															type="text" value="${user.phone}" class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">Email</label> <input
															type="text" value="${user.email}" class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">Address</label> <input
															type="text" value="${user.address}" class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">E-Wallet</label> <input
															type="text" value="${user.e_wallet}" class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">Created At</label> <input
															type="text" value="${user.createdAt}"
															class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">id_card</label> <input
															type="text" value="${user.id_card}"
															class="form-control" />
													</div>
													<div class="form-group">
														<label class="control-label">isEmailActive:</label>
														
															<select class="form-control" id="isEmailActive" name="isEmailActive">
																<option value="true" ${user.isEmailActive ? 'selected' : ''}>Yes</option>
																<option value="false" ${!user.isEmailActive ? 'selected' : ''}>No</option>
															</select>
													</div>
													<div class="form-group">
														<label class="control-label">isPhoneActive:</label>
															<select class="form-control" id="is_card" name="is_card">
																<option value="true" ${user.isPhoneActive ? 'selected' : ''}>Yes</option>
																<option value="false" ${!user.isPhoneActive ? 'selected' : ''}>No</option>
															</select>
													</div>
													<div class="margiv-top-10">
														<a href="#" class="btn green-haze"> Save Changes </a> <a
															href="#" class="btn default"> Cancel </a>
													</div>
												</form>
											</div>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END PROFILE CONTENT -->
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->