<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
    <jsp:body>
        <h1>Change Filter</h1>
        <form method="post">
            <div class="form-group">
                <label>Age from</label>
                <div class="row">
                    <div class="col-9">
                        <input name="ageFrom" value="${filter.ageFrom}" type="range" class="custom-range" min="18"
                               max="100"
                               id="ageFrom" onchange="onAgeFromChange(this.value)">
                    </div>
                    <div class="col-3">
                        <span id="lbAgeFrom">${filter.ageFrom}</span>
                    </div>
                </div>

            </div>
            <div class="form-group">
                <label>Age to</label>
                <div class="row">
                    <div class="col-9">
                        <input name="ageTo" value="${filter.ageTo}" type="range" class="custom-range"
                               min="${filter.ageFrom}" max="100"
                               id="ageTo" onchange="onAgeToChange(this.value)">
                    </div>
                    <div class="col-3">
                        <span id="lbAgeTo">${filter.ageTo}</span>
                    </div>
                </div>


            </div>
            <div class="form-group">
                <label>Interested in</label>
                <div class="row">
                    <div class="col-9">
                        <select class="custom-select" name="interestedIn">
                            <option value="0" ${filter.interestedIn==0?"selected":""}>Women</option>
                            <option value="1" ${filter.interestedIn==1?"selected":""}>Man</option>
                            <option value="-1" ${filter.interestedIn==-1?"selected":""}>All</option>
                        </select>
                    </div>
                </div>

            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <script>
            function onAgeFromChange(v) {
                var from = parseInt(v);
                var to = parseInt($("#ageTo").val());
                if(from>to){
                    $("#ageTo").val(from);
                    $("#lbAgeTo").text(from);
                }
                $("#lbAgeFrom").text(v);
                document.getElementById("ageTo").setAttribute("min", v);
            }

            function onAgeToChange(v) {
                $("#lbAgeTo").text(v);
            }
        </script>
    </jsp:body>
</t:master>