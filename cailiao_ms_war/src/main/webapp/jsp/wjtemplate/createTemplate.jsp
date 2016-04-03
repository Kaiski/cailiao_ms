<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="row">
    <form class="col s12">
        <h4 class="header">新建问卷模板</h4>
        <div class="row">
            <div class="input-field col s12">
                <input id="name" type="text" class="validate">
                <label for="name" class="">问卷名称</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="desc" type="text" class="validate">
                <label for="desc" class="">问卷描述</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="jspUrl" type="text" class="validate">
                <label for="jspUrl">问卷模板jsp页</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="beginTime" type="text" class="validate">
                <label for="beginTime">生效时间</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="beginTime" type="text" class="validate">
                <label for="beginTime">失效时间</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <a class="btn waves-effect waves-light blue">创建</a>
                <a class="btn waves-effect waves-light red modal-trigger" href="#warningModal">取消</a>
            </div>
        </div>
    </form>
</div>

<div id="warningModal" class="modal" style="display: none; opacity: 1; top: 0px;">
    <div class="modal-content">
        <p>取消后输入的内容将不被保存，请确认!</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="waves-effect waves-green btn-flat modal-action modal-close">不取消</a>
        <a href="#" class="waves-effect waves-red btn-flat modal-action modal-close">取消</a>
    </div>
</div>